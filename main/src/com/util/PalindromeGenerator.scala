package com.util

import scala.collection.mutable.ArrayBuffer

object PalindromeGenerator extends App {
  val input = args(0)
  val result: ArrayBuffer[Result] = generatePalindromeSubString(input)
  /*
  sort by the substring length in descending order
   */
  for (r <- result.sortWith(_.size > _.size))
    println(r.subString + "," + r.index + "," + r.size)


  def generatePalindromeSubString(inputString: String): ArrayBuffer[Result] = {


    var (i, j, n) = (0, 0, inputString.length)
    var subString = " "
    var palindromeResult: ArrayBuffer[Result] = new ArrayBuffer[Result]()


    while (i < n) {
      j = i + 1
      while (j <= n) {
        var result = false
        subString = inputString.substring(i, j)
        val len = subString.length
        //One character strings are not palindromes
        if (len > 1)
          result = isPalindrome(subString)
        if (result == true) {
          palindromeResult.append(Result(subString, i, subString.length))
        }
        j = j + 1

      }
      i = i + 1
    }
    return palindromeResult
  }

  def isPalindrome(subString: String): Boolean = {
    var (i, j) = (0, subString.length - 1)

    while (i < j) {
      if (subString.charAt(i) != subString.charAt(j))
        return false
      i = i + 1
      j = j - 1
    }

    return true
  }

}
