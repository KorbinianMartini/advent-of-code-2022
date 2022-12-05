package day1.calorie_counting

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

const val calorieList = "src/main/kotlin/day1/calorie_counting/calorieList"

fun main() {
    partOne()
    partTwo()
}
fun partOne() {
    val calorieReader = BufferedReader(FileReader(File(calorieList)))
    var currentCalories = 0
    var highestCalories = 0
    var line = calorieReader.readLine()
    while (line != null) {
        if (line != "") {
            currentCalories += Integer.parseInt(line)
        } else {
            highestCalories = if (currentCalories > highestCalories) currentCalories else highestCalories
            currentCalories = 0
        }
        line = calorieReader.readLine()
    }
    println(highestCalories)
}

fun partTwo() {
    val calorieReader = BufferedReader(FileReader(File(calorieList)))
    var currentCalories = 0
    val calories = mutableListOf<Int>()
    var line = calorieReader.readLine()
    while (line != null) {
        if (line != "") {
            currentCalories += Integer.parseInt(line)
        } else {
            calories.add(currentCalories)
            currentCalories = 0
        }
        line = calorieReader.readLine()
    }
    calories.sortDescending()
    println(calories[0] + calories[1] + calories[2])
}