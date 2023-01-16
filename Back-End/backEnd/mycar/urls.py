from unicodedata import name
from django.urls import path
from . import views

urlpatterns =[


path('login/',views.Login,name='login'),
path('logout/',views.logout,name='logout'),
path( 'all_objects/',views.all_objects,name='all_objects'),
path( 'Registration/',views.Registration,name='Registration')


]