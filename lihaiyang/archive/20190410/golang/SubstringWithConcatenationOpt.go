// SubstringWithConcatenationOpt.go
// Author: hyan23
// 2019.04.09
// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

package main

import "fmt"

/*
func findSubstring(s string, words []string) []int {
	if len(s) == 0 || len(words) == 0 {
		return []int{}
	}

	length := len(words[0])
	indices := []int{}
	if len(s) < len(words)*length {
		return indices
	}

	m := make(map[string]int)
	for _, word := range words {
		m[word]++
	}

	for i := 0; i < length; i++ {
		for j := i; j < len(s); {
			m2 := make(map[string]int)
			wordPos := make(map[string]int)
			count := 0

			notFound := false
			duplicate := false

			k := j
			fragment := s
			for ; k+length <= len(s); k += length {
				fragment = s[k : k+length]
				if _, ok := m[fragment]; ok {
					m2[fragment]++
					count++
					if _, ok2 := wordPos[fragment]; !ok2 {
						wordPos[fragment] = k
					}
					if m2[fragment] > m[fragment] {
						duplicate = true
						break
					}
				} else {
					notFound = true
					break
				}
				if count == len(words) {
					indices = append(indices, j)
					break
				}
			}
			if notFound {
				j = k + length
			} else if duplicate {
				j = wordPos[fragment] + length
			} else {
				j = j + length
			}
		}
	}
	return indices
}
*/

func findSubstring(s string, words []string) []int {
	if len(s) == 0 || len(words) == 0 {
		return []int{}
	}

	wordLength := len(words[0])
	subStrLength := len(words) * wordLength
	if len(s) < subStrLength {
		return []int{}
	}

	m := make(map[string]int)
	for _, word := range words {
		m[word]++
	}

	indices := []int{}

	for i := 0; i < wordLength; i++ {
		m2 := make(map[string]int)
		count := 0
		substr := []string{}
		wordPos := make(map[string][]int)
		for j := i; j < len(s); {
			notFound := false
			duplicate := false
			match := false

			k := j
			fragment := s
			for ; k+wordLength <= len(s); k += wordLength {
				fragment = s[k : k+wordLength]
				if _, ok := m[fragment]; ok {
					substr = append(substr, fragment)
					if _, ok2 := wordPos[fragment]; !ok2 {
						wordPos[fragment] = []int{}
					}
					wordPos[fragment] = append(wordPos[fragment], k)
					m2[fragment]++
					count++
					if m2[fragment] > m[fragment] {
						duplicate = true
						break
					}
				} else {
					notFound = true
					break
				}
				if count == len(words) {
					indices = append(indices, k+wordLength-subStrLength)
					match = true
					break
				}
			}
			if notFound {
				j = k + wordLength
			} else if duplicate {
				j = wordPos[fragment][0] + wordLength
			} else if match {
				first := substr[0]
				substr = substr[1:]
				wordPos[first] = wordPos[first][1:]
				m2[first]--
				count--
				j = k + wordLength
			} else {
				j = j + wordLength
			}
			if !match {
				m2 = make(map[string]int)
				substr = []string{}
				count = 0
				wordPos = make(map[string][]int)
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
