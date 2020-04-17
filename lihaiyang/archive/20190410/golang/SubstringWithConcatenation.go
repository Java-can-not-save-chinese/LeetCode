// SubstringWithConcatenation.go
// Author: hyan23
// 2019.04.09
// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

package main

import "fmt"

func findSubstring(s string, words []string) []int {
	if len(words) == 0 {
		return []int{}
	}
	m := make(map[string]int)
	for _, word := range words {
		m[word]++
	}
	length := len(words[0])
	indices := []int{}
	for i, _ := range s {
		m2 := make(map[string]int)
		count := 0
		for j := i; j+length <= len(s); j += length {
			fragment := s[j : j+length]
			if _, ok := m[fragment]; ok {
				m2[fragment]++
				count++
				if m2[fragment] > m[fragment] {
					break
				}
			} else {
				break
			}
			if count == len(words) {
				indices = append(indices, i)
				break
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
}
