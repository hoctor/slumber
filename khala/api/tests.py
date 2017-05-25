from django.test import TestCase

from rest_framework.test import APIClient
from rest_framework import status
from django.core.urlresolvers import reverse
from django.test import TestCase
from .models import ArduinoSignal, AndroidSignal


class AndroidSignalTestCase(TestCase):
    """This class defines the test suite for the UserSignal model."""

    def setUp(self):
        """Define the test client and other test variables."""
        self.AndroidSignal_name = "Write world Android class code bla"
        self.AndroidSignal = AndroidSignal(name=self.AndroidSignal_name)

    def test_model_can_create_a_AndroidSignal(self):
        """Test the UserSignal model can create a UserSignal."""
        old_count = AndroidSignal.objects.count()
        self.AndroidSignal.save()
        new_count = AndroidSignal.objects.count()
        self.assertNotEqual(old_count, new_count)


class AndroidViewTestCase(TestCase):
    """Test suite for the api views."""

    def setUp(self):
        """Define the test client and other test variables."""
        self.client = APIClient()
        self.androidsignal_data = {'name': 'Go to Ibiza with Android'}
        self.response = self.client.post(
            reverse('create'),
            self.androidsignal_data,
            format="json")

    def test_api_can_create_a_androidsignal(self):
        """Test the api has bucket creation capability."""
        self.assertEqual(self.response.status_code, status.HTTP_201_CREATED)


class ArduinoSignalTestCase(TestCase):
    """This class defines the test suite for the UserSignal model."""

    def setUp(self):
        """Define the test client and other test variables."""
        self.ArduinoSignal_name = "Write world Arduino class code bla"
        self.ArduinoSignal = ArduinoSignal(name=self.ArduinoSignal_name)

    def test_model_can_create_a_ArduinoSignal(self):
        """Test the UserSignal model can create a UserSignal."""
        old_count = ArduinoSignal.objects.count()
        self.ArduinoSignal.save()
        new_count = ArduinoSignal.objects.count()
        self.assertNotEqual(old_count, new_count)


class ArduinoViewTestCase(TestCase):
    """Test suite for the api views."""

    def setUp(self):
        """Define the test client and other test variables."""
        self.client = APIClient()
        self.arduinosignal_data = {'name': 'Go to Ibiza with Arduino'}
        self.response = self.client.post(
            reverse('create'),
            self.arduinosignal_data,
            format="json")

    def test_api_can_create_a_arduinosignal(self):
        """Test the api has bucket creation capability."""
        self.assertEqual(self.response.status_code, status.HTTP_201_CREATED)
