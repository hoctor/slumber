from __future__ import unicode_literals

from django.db import models


class AndroidSignal(models.Model):
    """This class represents the UserSignal model."""
    user_id = models.CharField(max_length=255, blank=False, unique=True)
    weight = models.FloatField(default=50)
    x = models.FloatField(default=0)
    y = models.FloatField(default=0)
    z = models.FloatField(default=0)
    date_created = models.DateTimeField(auto_now_add=True)
    date_modified = models.DateTimeField(auto_now=True)

    def __str__(self):
        """Return a human readable representation of the model instance."""
        return "{}".format(self.name)


class ArduinoSignal(models.Model):
    """This class represents the UserSignal model."""
    user_id = models.CharField(max_length=255, blank=False, unique=True)
    frequency = models.FloatField(default=0)
    date_created = models.DateTimeField(auto_now_add=True)
    date_modified = models.DateTimeField(auto_now=True)

    def __str__(self):
        """Return a human readable representation of the model instance."""
        return "{}".format(self.name)