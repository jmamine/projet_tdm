from unicodedata import name
from django.urls import path
from . import views

urlpatterns =[
path('',views.home),

path('login/',views.Login,name='login'),
path('logout/',views.logout,name='logout'),



]