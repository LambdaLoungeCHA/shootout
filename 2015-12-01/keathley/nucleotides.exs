defmodule Sequencer do
  def count("", counts), do: counts
  def count("A" <> rest, {a, c, g, t}), do: count(rest, {a+1, c, g, t})
  def count("C" <> rest, {a, c, g, t}), do: count(rest, {a, c+1, g, t})
  def count("G" <> rest, {a, c, g, t}), do: count(rest, {a, c, g+1, t})
  def count("T" <> rest, {a, c, g, t}), do: count(rest, {a, c, g, t+1})
end

sequence = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"
{a,c,g,t} = Sequencer.count(sequence, {0,0,0,0})
IO.puts "#{a} #{c} #{g} #{t}"
