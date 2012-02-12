start = Time.new # debug only

data = []
File.open("names.txt", "r") do |file|
    while (name = file.gets(','))
        data << name.delete('",')
    end
end

result = data.sort.zip((2..(data.length+2)).to_a).inject(0) do |total, (name, index)|
  total + name.bytes.inject(0) { |sum, b| sum + b - ?A + 1 } * index
end

print result, ", ", Time.new - start, " secs\n" # 871198282
