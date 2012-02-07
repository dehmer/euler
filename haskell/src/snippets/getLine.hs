main = do -- combine several IO actions
    foo <- putStrLn "Hello, what's your name?" -- possible to bind to `foo`, but without much sense
    name <- getLine
    putStrLn ("Hey " ++ name ++ ", you rock!") -- the last action cannot be bound to a name
