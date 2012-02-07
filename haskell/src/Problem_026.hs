import Data.List

-- A Haskell solution, taking advantage of the fact that the period of a
-- number n's reciprocal is the smallest k such that n divides 10^k - 1.

main = print answer

nums = [ n | n <- [3, 5..], mod n  5 /= 0 ]
period n = head $ [ p | p <- [1..], mod (10 ^ p - 1) n == 0 ]

answer =
    fst $
    maximumBy (\(_,a) (_,b) -> compare a b) $
    map (\n -> (n, period n)) $
    takeWhile (< 1000) nums
