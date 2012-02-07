import qualified Data.List.Stream as S
import Data.Numbers.Primes

main = print . S.length . S.takeWhile (<= 2000000) $ primes