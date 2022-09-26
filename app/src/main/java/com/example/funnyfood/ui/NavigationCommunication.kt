package com.example.funnyfood.ui

import com.example.funnyfood.core.Communication

interface NavigationCommunication : Communication<Int> {
    class Base : Communication.Base<Int>(), NavigationCommunication
}