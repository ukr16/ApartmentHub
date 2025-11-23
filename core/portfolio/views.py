from django.shortcuts import render
# Create your views here.

def home(request):
    context = {'page':'Home'}
    return render(request, "homepage.html",context)

def about(request):
    context = {'page':'About'}
    return render(request, "about.html",context)

def contact(request):
    context = {'page':'Contact'}
    return render(request, "contact.html",context)

def experience(request):
    context = {'page':'Experience'}
    return render(request, "experience.html",context)




