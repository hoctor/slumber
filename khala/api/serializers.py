from rest_framework import serializers
from .models import AndroidSignal, ArduinoSignal


class AndroidSignalSerializer(serializers.ModelSerializer):
    """Serializer to map the Model instance into JSON format."""

    class Meta:
        """Meta class to map serializer's fields with the model fields."""
        model = AndroidSignal
        fields = ('id', 'user_id', 'weight', 'x', 'y', 'z',  'date_created', 'date_modified')
        read_only_fields = ('date_created', 'date_modified')


class ArduinoSignalSerializer(serializers.ModelSerializer):
    """Serializer to map the Model instance into JSON format."""

    class Meta:
        """Meta class to map serializer's fields with the model fields."""
        model = ArduinoSignal
        fields = ('id', 'user_id', 'frequency', 'date_created', 'date_modified')
        read_only_fields = ('date_created', 'date_modified')