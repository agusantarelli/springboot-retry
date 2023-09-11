package com.example.springbootretry.shared

class FileReader {
    companion object {
        fun execute(path: String): String {
            val contextClassLoader = Thread.currentThread().contextClassLoader
            return contextClassLoader.getResource(path).readText()
        }
    }
}
