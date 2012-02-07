import Data.List

main = do
    print $ head $ drop 999999 (sort (permutation "0123456789"))

permutation [] = [[]]
permutation xs = [x:ys | x <- xs, ys <- permutation (delete x xs)]

