from django.shortcuts import render

from rest_framework import generics
from .serializers import AndroidSignalSerializer, ArduinoSignalSerializer
from .models import ArduinoSignal, AndroidSignal


class AndroidCreateView(generics.ListCreateAPIView):
    """This class defines the create behavior of our rest api."""
    queryset = AndroidSignal.objects.all()
    serializer_class = AndroidSignalSerializer

    def perform_create(self, serializer):
        """Save the post data when creating a new bucketlist."""
        serializer.save()


class ArduinoCreateView(generics.ListCreateAPIView):
    """This class defines the create behavior of our rest api."""
    queryset = ArduinoSignal.objects.all()
    serializer_class = ArduinoSignalSerializer

    def perform_create(self, serializer):
        """Save the post data when creating a new bucketlist."""
        serializer.save()