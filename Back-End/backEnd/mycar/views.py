from dataclasses import dataclass
import email
from urllib import response
from django.shortcuts import render
from django.http import HttpResponse
from .models import User , car ,reservation
from django.http import JsonResponse
from django.core import serializers
from django.core.exceptions import ValidationError
from uuid import uuid4
import json
from django.views.decorators.csrf import csrf_exempt

@csrf_exempt
def Registration(request):
   
    if request.method == 'POST':
      username_test=request.POST.get('username')
      email_test= request.POST.get('email')
      password_test = request.POST.get('password')
      phone_number_test=request.POST.get('phone_number')
      credit_card_test=request.POST.get('credit_card')
      permis_test=request.POST.get('permis')



    if not email_test or not  password_test or not username_test or not phone_number_test or not credit_card_test or not permis_test :
            raise ValidationError("Details not entered.")

    if not '@' in email_test:    
         raise ValidationError("User credentials are not correct.")    
            
    user= User.objects.filter( email=email_test )
   
    if  user.exists():
                raise ValidationError("this email is already taken")
   
    
    for object in user:
        
        object.ifLogged = True
        object.token = uuid4()
        object.save()


    data = serializers.serialize('json',  user ) 
    return HttpResponse(data, content_type="text/json-comment-filtered")

@csrf_exempt
def Login(request):
   
    if request.method == 'POST':
      email_test= request.POST.get('email')
      password_test = request.POST.get('password')



    if not email_test or not  password_test:
            raise ValidationError("Details not entered.")

    if not '@' in email_test:    
         raise ValidationError("User credentials are not correct.")    
            
    user= User.objects.filter( email=email_test ).filter(password=password_test)
   
    if not user.exists():
                raise ValidationError("User credentials are not correct.")
   
    
    for object in user:
        if object.ifLogged:
            raise ValidationError("User already logged in.")
        object.ifLogged = True
        object.token = uuid4()
        object.save()


    data = serializers.serialize('json',  user ) 
    return HttpResponse(data, content_type="text/json-comment-filtered")


@csrf_exempt    
def Login(request):
   
    if request.method == 'POST':
      email_test= request.POST.get('email')
      password_test = request.POST.get('password')



    if not email_test or not  password_test:
            raise ValidationError("Details not entered.")

    if not '@' in email_test:    
         raise ValidationError("User credentials are not correct.")    
            
    user= User.objects.filter( email=email_test ).filter(password=password_test)
   
    if not user.exists():
                raise ValidationError("User credentials are not correct.")
   
    
    for object in user:
        if object.ifLogged:
            raise ValidationError("User already logged in.")
        object.ifLogged = True
        object.token = uuid4()
        object.save()


    data = serializers.serialize('json',  user ) 
    return HttpResponse(data, content_type="text/json-comment-filtered")

@csrf_exempt
def logout(request):
     

     if request.method == 'POST':
      username_test= request.POST.get('username')
     user= User.objects.filter( username=username_test )
     for object in user:
        if not object.ifLogged:
                 raise ValidationError("User is not logged in.")
        object.ifLogged = False
        object.token = ""
        object.save()
     return HttpResponse('User is logged out.')
     


@csrf_exempt
def all_objects(request):
    # get method handler

    data = serializers.serialize("json", car.objects.all(), fields = ("marque","modele","acceleration","seat","x","y","price","iftaken"))
    return HttpResponse(data, content_type="text/json-comment-filtered")


