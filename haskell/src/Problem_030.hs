import Char

main = print $ sum [x | x <- [2..5 * 9^5], x == (sum . map ((^5) . digitToInt) . show) x]
