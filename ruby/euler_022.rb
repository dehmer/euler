data = File.open("names.txt", "r").each(',').collect { |name| name.delete('",') }
result = data.sort.zip((2..(data.length+2)).to_a).inject(0) do |total, (name, index)|
  total + name.bytes.inject(0) { |sum, b| sum + b - ?A + 1 } * index
end

print result, "\n"
