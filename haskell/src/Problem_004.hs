-- Find the largest palindrome made from the product of two 3-digit numbers.

module Main where
import Data.List

isPalindrome xs = xs == (reverse xs)
main = print (last (sort [x * y| x <- [900..999], y <- [x..999], isPalindrome (show (x * y))]))
