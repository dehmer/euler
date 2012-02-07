-- Evaluate the sum of all the amicable numbers under 10000.
main = print $ sum [a + b | a <- [1..10000], let b = sumDivisors a, (sumDivisors b == a) && a < b]
sumDivisors n = sum $ 1 : (filter (\x -> rem n x == 0) [2 .. div n 2])

