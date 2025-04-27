package org.wikipedia.works.lesson04

import org.junit.Test

//DSL -

//если тапнуть на скобочку - переход на функцию invoke (выполнить)
// когда вызываем функцию invoke перегружает (оператор) занчение в круглых скобочках

//object - класс который уже проинициализирован. уникальный, второй раз не создать

// MainScreen.simpleButton.isVisible()
// MainScreen.simpleButton.click()

//с примениением DSL эти две строчки выглядят как
// MainScreen {
//      simpleButton {
//          isVisible()
//          click()
//      }
// }
// Внутри фигурных скобок нам доступны все объекты для MainScreen

// infix - функция которая позволяет записывать ввиде "1" to "2"