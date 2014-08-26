""" Lambda Lounga Chattanooga - Language Shootout 2014
http://lambdalounge.org/2013/04/14/2013-language-shootout/

Runs under Python 2.7
To perform tests, run "python shootout.py -v"
"""
__author__ = "Stephen Spalding"

def dna(string):
    """ Counting DNA Nucleotides
    Example:
    >>> dna("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")
    20 12 17 21
    """
    n = {'A':0,'C':0,'G':0,'T':0}
    for c in string:
        n[c] += 1
    print n['A'],n['C'],n['G'],n['T']

def dna2(s):
    """ Counting DNA Nucleotides using str.count builtin method
    Example:
    >>> dna2("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")
    20 12 17 21
    """
    for c in 'ACGT': print s.count(c),

def fib(n,k=1,a=1,b=0):
    """ Wascally Wabbits
    Example:
    >>> fib(5,3)
    19
    >>> [fib(x,3) for x in range(1,10)]
    [1, 1, 4, 7, 19, 40, 97, 217, 508]
    >>> [fib(x) for x in range(1,10)]
    [1, 1, 2, 3, 5, 8, 13, 21, 34]
    """
    return fib(n-1,k,a+b*k,a) if n>1 else a

def mendel(a,b,c):
    """ Mendel's First Law
    Example:
    >>> mendel(2,2,2)
    0.78333333333333333
    >>> mendel(1e12,1e12,1e12)
    0.75000000000005584
    """
    return (a**2+.75*b**2+2*a*b+2*a*c-a-.75*b+b*c)/(a+b+c)/(a+b+c-1)

def wav(filename):
    """ WAV file format reader/player """
    import wave, pymedia.audio.sound as sound
    with wave.open(filename, 'rb') as f:
        snd = sound.Output(f.getframerate(), f.getnchannels(), sound.AFMT_S16_LE)
        snd.play( f.readframes() )

if __name__ == "__main__":
    import doctest
    doctest.testmod()
