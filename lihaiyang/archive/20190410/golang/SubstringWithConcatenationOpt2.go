// SubstringWithConcatenationOpt2.go
// Author: hyan23
// 2019.04.10
// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

// Runtime: 16 ms (72.75% faster)
// Best solution: 0 ms

package main

import "fmt"

func findSubstring(s string, words []string) []int {
	wordCount := len(words)
	if len(s) == 0 || wordCount == 0 {
		return []int{}
	}

	wordLength := len(words[0])
	subStrLength := wordCount * wordLength
	if len(s) < subStrLength {
		return []int{}
	}

	m := map[string]int{}
	for _, word := range words {
		m[word]++
	}

	indices := []int{}

	for i := 0; i < wordLength; i++ {
		m2 := map[string]int{}
		count := 0
		count2 := 0
		duplicate := 0
		sequence := []string{}
		for j := i; j <= len(s)-wordLength; j += wordLength {
			fragment := s[j : j+wordLength]
			sequence = append(sequence, fragment)

			m2[fragment]++
			count++
			if _, ok := m[fragment]; ok {
				count2++
				if m2[fragment] > m[fragment] {
					duplicate++
				}
			}

			if j-i >= subStrLength-wordLength {
				if count2 == count && count2 == wordCount && duplicate == 0 {
					indices = append(indices, j+wordLength-subStrLength)
				}
				first := sequence[0]
				sequence = sequence[1:]
				if _, ok := m[first]; ok {
					if m2[first]-1 == m[first] {
						duplicate--
					}
					count2--
				}
				m2[first]--
				count--
			}
		}
	}
	return indices
}

func main() {
	fmt.Println(findSubstring("barfoothefoobarman", []string{"foo", "bar"}))
	fmt.Println(findSubstring("wordgoodgoodgoodbestword", []string{"word", "good", "best", "word"}))
	fmt.Println(findSubstring("barfoofoobarthefoobarman", []string{"bar", "foo", "the"}))
	fmt.Println(findSubstring("wordgoodgoodgoodbestword", []string{"word", "good", "best", "good"}))
	fmt.Println(findSubstring("wordgoodgoodgoodbestword", []string{"good"}))
	fmt.Println(findSubstring("oooooooooooooooaooooooaaa", []string{"ooo", "ooo"}))
	fmt.Println(findSubstring("aaa", []string{"a", "a"}))
}
