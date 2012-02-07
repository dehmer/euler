
main = print $ maxPrimeFactor 600851475143

maxPrimeFactor n = divide n 2 where
  divide n fac
    | n == fac = fac
    | mod n fac == 0 = divide (div n fac) fac
    | otherwise = divide n (succ fac)
