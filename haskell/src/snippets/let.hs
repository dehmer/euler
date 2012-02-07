import Data.Char

main = do
    putStrLn "What's your first name?"
    firstName <- getLine
    putStrLn "What's your last name?"
    lastName <- getLine

    -- noticed the two lets with same intend?
    let bigFirstName = map toUpper firstName
        bigLastName = map toUpper lastName

    putStrLn $ "hey " ++ bigFirstName ++ " " ++ bigLastName ++ ", how are you?"