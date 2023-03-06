from dataclasses import dataclass
from urllib import response
import random
from django.http import HttpResponse
from .models import User , car ,reservation
from django.http import JsonResponse
from django.core import serializers
from django.core.exceptions import ValidationError
from uuid import uuid4
import json
from django.views.decorators.csrf import csrf_exempt
import os
from django.conf import settings



# sign up function

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
   
    


    b = User(username=username_test, email=email_test ,password=password_test,permis=permis_test,credit_card=credit_card_test,phonenumber=phone_number_test,ifLogged = True,token = uuid4())
    b.save()
    b= User.objects.filter( email=email_test )
    
    data = serializers.serialize('json', b ) 
    return HttpResponse(data, content_type="text/json-comment-filtered")




@csrf_exempt
def Login(request):
     
     

   
    # if request.method == 'POST':
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
    json_data = [dict(pk=obj['pk'], **obj['fields']) for obj in json.loads(data)]
    return JsonResponse(json_data, safe=False)


    


@csrf_exempt
def logout(request):
     

     if request.method == 'POST':
      username_test= request.POST.get('username')
     user= User.objects.filter(username=username_test )
     for object in user:
        if not object.ifLogged:
                 raise ValidationError("User is not logged in.")
        object.ifLogged = False
        object.token = ""
        object.save()
        
     return HttpResponse('User is logged out.')

    
# recupuer la liste de toutes les voiture alloue par l utilisateur
@csrf_exempt
def historique (request):
      if request.method == 'POST':
       user_email_test= request.POST.get('email')

      user_tset=User.objects.get(email=user_email_test)
      my_reservations=reservation.objects.filter(User_id=user_tset.pk)
    
      
      
    
      data = serializers.serialize('json', my_reservations)
      json_data = [dict(pk=obj['pk'], **obj['fields']) for obj in json.loads(data)]
      
      
      return JsonResponse( json_data, safe=False)


@csrf_exempt
def cars (request):
      if request.method == 'POST':
       user_email_test= request.POST.get('email')

      user_tset=User.objects.get(email=user_email_test)
      my_reservations=reservation.objects.filter(User_id=user_tset.pk)
      car_queryset = car.objects.filter(reservation__in=my_reservations, iftaken=True)
    
      
      
    
      data = serializers.serialize('json',car_queryset)
      json_data = [dict(pk=obj['pk'], **obj['fields']) for obj in json.loads(data)]
      
      
      return JsonResponse( json_data, safe=False)


   
      





     


@csrf_exempt
def all_objects(request):
    cars = car.objects.all()
    data = serializers.serialize("json", cars, fields=("marque", "modele", "acceleration", "seat", "x", "y", "price", "iftaken"))

    json_data = [dict(pk=obj['pk'], **obj['fields']) for obj in json.loads(data)]

    return JsonResponse(json_data, safe=False)


@csrf_exempt
def Reservation(request):
    
    if request.method == 'POST':
      car_id= request.POST.get('car_id')
      user_email = request.POST.get('user_email')
      date_debut=request.POST.get('date_debute')
      
    PIN= random.randint(0, 9999)
    user_test = User.objects.get(email=user_email)
    car_test = car.objects.get(pk=car_id) 
    if  car_test.iftaken:
                 raise ValidationError("already taken")
    new_reservation=reservation( User= user_test,car= car_test,DateDebute=date_debut ) 
    new_reservation.save()
    

    car_test.iftaken=True
    car_test.Pin=PIN
    car_test.save()

    
    return HttpResponse(PIN)


@csrf_exempt
def End_Reservation(request):
    
    if request.method == 'POST':
      reservation_id_test= request.POST.get('reservation_id')
      date_fin=request.POST.get('date_fin')

    reservation_test = reservation.objects.get(pk=reservation_id_test)
    reservation_test.DateFin = date_fin
    reservation_test.save()

    car_test=reservation_test.car
    car_test.Pin=None
    car_test.iftaken=False
    car_test.save()
    
    return HttpResponse('done')    


# fileter fait le filtrage par rapport les variable du post-body mais si ce variable est null il ne sera pas compter au filtrage

@csrf_exempt
def filter(request):
    if request.method == 'POST':
        marque_test = request.POST.get('marque')
        modele_test = request.POST.get('modele')
        iftaken_test = request.POST.get('iftaken')
        acceleration_test = request.POST.get('acceleration')
        seat_test = request.POST.get('seat')
        price_test = request.POST.get('price')

        filters = {}

        if marque_test:
            filters['marque__contains'] = marque_test
        if modele_test:
            filters['modele__contains'] = modele_test
        if iftaken_test:
            filters['iftaken'] = iftaken_test
        if acceleration_test:
            filters['acceleration__contains'] = acceleration_test
        if seat_test:
            filters['seat'] = seat_test
        if price_test:
            filters['price'] = price_test

       
        car_list = car.objects.filter(**filters)

        
        data = serializers.serialize('json', car_list)
        json_data = [dict(pk=obj['pk'], **obj['fields']) for obj in json.loads(data)]
        return HttpResponse(json_data, content_type='application/json')
    
# @csrf_exempt
# def Lock(request):
#     if request.method == 'POST':
#         marque_test = request.POST.get('marque')
#         modele_test = request.POST.get('modele')
#         iftaken_test = request.POST.get('iftaken')
#         acceleration_test = request.POST.get('acceleration')
#         seat_test = request.POST.get('seat')
#         price_test = request.POST.get('price')

#         filters = {}

        

       
#         car_list = car.objects.filter(**filters)

        
#         data = serializers.serialize('json', car_list)
#         json_data = [dict(pk=obj['pk'], **obj['fields']) for obj in json.loads(data)]
#         return HttpResponse(json_data, content_type='application/json')


@csrf_exempt
def get_image(request):
    if request.method == 'POST':
      image_url_test= request.POST.get('image_url')
    image_path = os.path.join(settings.BASE_DIR, image_url_test)
    with open(image_path, "rb") as f:
        image = f.read()
    return HttpResponse(image, content_type="image/jpeg")




# class CustomCarSerializer(ModelSerializer):
#     class Meta:
#         model = car
#         fields = '__all__'

#     def to_representation(self, instance):
#         data = super().to_representation(instance)
#         data.pop('model')
#         data.pop('fields')
#         return data    
