from django.db import models

# on utilise django orm pour implementer notre base de donnes 


#une table user pour gerer les donnes d utilisateur 

class User(models.Model):
    username = models.CharField(max_length=255, null=False)
    email = models.EmailField(max_length=255, null=False)
    password = models.CharField(max_length=50)
    ifLogged = models.BooleanField(default=False)
    phonenumber= models.CharField(max_length=255, null=False)
    permis=models.IntegerField(default='0')
    credit_card=models.IntegerField(default='0')
    token = models.CharField(max_length=500, null=True, default="")

    def __str__(self):
        return "{} -{}".format(self.username, self.email)


#une table car pour gerer les donnes des voitures

class car (models.Model):
    marque = models.CharField(max_length=255, null=False)
    image_marque = models.CharField(max_length=255, null=False)
    modele = models.CharField(max_length=255, null=False)
    iftaken = models.BooleanField(default=False)
    acceleration= models.CharField(max_length=255, null=False)
    seat= models.IntegerField()
    x= models.FloatField()
    y= models.FloatField()
    
    pic= models.CharField(max_length=255, null=False)
    price= models.FloatField()
    Users = models.ManyToManyField(User, through='reservation')
    Pin = models.CharField(max_length=255,default='',null=True)
    image_car_url = models.CharField(max_length=200,default='')
    image_mark_url = models.CharField(max_length=200,default='')

    def __str__(self):
        return "{} -{}".format(self.marque, self.modele)

#une table reservation qui sera l'intermédiaire entre les

class reservation(models.Model):
    User = models.ForeignKey(User,on_delete=models.CASCADE)
    car = models.ForeignKey(car,on_delete=models.CASCADE)
    DateDebute = models.CharField(max_length=255,default="")
    DateFin = models.CharField(max_length=255 ,default="")
    

    def __str__(self):
        return "{} -{}".format(self.User,self.car)        




