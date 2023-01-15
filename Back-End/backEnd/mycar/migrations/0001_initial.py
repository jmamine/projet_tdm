# Generated by Django 4.1.5 on 2023-01-15 23:29

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Car',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('marque', models.CharField(max_length=255)),
                ('image_marque', models.CharField(max_length=255)),
                ('modele', models.CharField(max_length=255)),
                ('iftaken', models.BooleanField(default=False)),
                ('acceleration', models.CharField(max_length=255)),
                ('seat', models.IntegerField()),
                ('x', models.FloatField()),
                ('y', models.FloatField()),
                ('pic', models.CharField(max_length=255)),
                ('price', models.FloatField()),
            ],
        ),
        migrations.CreateModel(
            name='User',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('username', models.CharField(max_length=255)),
                ('email', models.EmailField(max_length=255)),
                ('password', models.CharField(max_length=50)),
                ('ifLogged', models.BooleanField(default=False)),
                ('phonenumber', models.CharField(max_length=255)),
                ('permit', models.IntegerField()),
                ('credit_card', models.IntegerField()),
                ('token', models.CharField(default='', max_length=500, null=True)),
            ],
        ),
        migrations.CreateModel(
            name='Reservation',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('DateDebute', models.DateField()),
                ('DateFin', models.DateField()),
                ('Pin', models.IntegerField()),
                ('User', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='mycar.user')),
                ('car', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='mycar.car')),
            ],
        ),
        migrations.AddField(
            model_name='car',
            name='Users',
            field=models.ManyToManyField(through='mycar.Reservation', to='mycar.user'),
        ),
    ]
