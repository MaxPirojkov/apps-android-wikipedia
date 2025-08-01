package org.wikipedia.works.lesson12

import androidx.room.AmbiguousColumnResolver
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule

/*
Конфигуратор Каспрессо

Интерсепторы  - это перехватчики
при выполнении какого то действия или проверки
Интерсепторы это специальные классы которые выполняются перед действием или проверки
например передают в логкат инфо о проверках или действиях

 */

//class Lesson12 : TestCase(
//    kaspressoBuilder = Kaspresso.Builder.advanced{
//        flakySafetyParams = FlakySafetyParams.custom(30000, FlakySafetyParams.defaultAllowedExceptions.plus(
//            AmbiguousColumnResolver::class.java
//        ))
//    }
//)