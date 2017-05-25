from django.conf.urls import url, include
from rest_framework.urlpatterns import format_suffix_patterns
from .views import AndroidCreateView, ArduinoCreateView

urlpatterns = {
    url(r'^android/$', AndroidCreateView.as_view(), name="create"),
    url(r'^arduino/$', ArduinoCreateView.as_view(), name="create"),
}

urlpatterns = format_suffix_patterns(urlpatterns)