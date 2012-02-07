
main = print (length (takeWhile (<10^999) fib) + 1)

fib = 1 : 1 : fib' (fib)
	where
		fib' (x : y : rest) = x + y : fib' (y : rest)
