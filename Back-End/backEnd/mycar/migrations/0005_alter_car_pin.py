# Generated by Django 4.1.5 on 2023-02-24 03:00

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('mycar', '0004_car_image_car_url_car_image_mark_url'),
    ]

    operations = [
        migrations.AlterField(
            model_name='car',
            name='Pin',
            field=models.CharField(default='', max_length=255),
        ),
    ]