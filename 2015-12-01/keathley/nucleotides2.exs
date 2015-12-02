defmodule Sequence do
  defstruct a: 0, c: 0, g: 0, t: 0

  def count("", sequence), do: sequence
  def count("A" <> rest, %{a: a}=s), do: count(rest, %{s | a: a+1})
  def count("C" <> rest, %{c: c}=s), do: count(rest, %{s | c: c+1})
  def count("G" <> rest, %{g: g}=s), do: count(rest, %{s | g: g+1})
  def count("T" <> rest, %{t: t}=s), do: count(rest, %{s | t: t+1})
end

defimpl String.Chars, for: Sequence do
  def to_string(%{a: a, c: c, g: g, t: t}) do
    "#{a} #{c} #{g} #{t}"
  end
end

defmodule Nucleotide do
  def main do
    string = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"
    IO.puts Sequence.count(string, %Sequence{})
  end
end

Nucleotide.main()
