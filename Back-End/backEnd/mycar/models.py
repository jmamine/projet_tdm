from django.db import models




class User(models.Model):
    username = models.CharField(max_length=255, null=False)
    email = models.EmailField(max_length=255, null=False)
    password = models.CharField(max_length=50)
    ifLogged = models.BooleanField(default=False)
    phonenumber= models.CharField(max_length=255, null=False)
    permit=models.IntegerField()
    credit_card=models.IntegerField()
    token = models.CharField(max_length=500, null=True, default="")

    def __str__(self):
        return "{} -{}".format(self.username, self.email)




class Car(models.Model):
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
    Users = models.ManyToManyField(User, through='Reservation')

    def __str__(self):
        return "{} -{}".format(self.marque, self.modele)



class Reservation(models.Model):
    User = models.ForeignKey(User,on_delete=models.CASCADE)
    car = models.ForeignKey(Car,on_delete=models.CASCADE)
    DateDebute = models.DateField()
    DateFin = models.DateField()
    Pin = models.IntegerField()

    def __str__(self):
        return "{} -{}".format(self.User, self.car)        




