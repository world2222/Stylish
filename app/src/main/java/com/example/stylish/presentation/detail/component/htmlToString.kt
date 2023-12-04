package com.example.stylish.presentation.detail.component

fun htmlToString(htmlText: String): String {
    return htmlText
        .replace("<br>", "\n")
        .replace("<li>", "\t\t• ")
        .replace("</li>", "\n")
        .replace(Regex("<.*?>"), "")
}