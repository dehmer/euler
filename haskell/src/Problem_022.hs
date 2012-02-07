import Data.List
import Data.Char

main = do
  names <- readNames "names.txt"
  let sortedNames = sort names
  let sortedValues = map (value) sortedNames
  print $ sum $ map (\x -> fst x * snd x) (zip [1..] sortedValues)

splitLine s = map (\x -> take ((length x) - 2) (drop 1 x)) (split s ',')

readNames fileName = do
  text <- readFile fileName
  return (splitLine text)

split [] delim = [""]
split (c : cs) delim
   | c == delim = "" : rest
   | otherwise = (c : head rest) : tail rest
   where
       rest = split cs delim

value s = sum $ map (\x -> ord x - ord 'A' + 1) s