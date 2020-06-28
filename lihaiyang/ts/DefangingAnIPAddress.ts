// DefangingAnIPAddress.ts
// Author: hyan23
// 2020.06.28
// https://leetcode.com/problems/defanging-an-ip-address/

/*
Runtime: 60 ms, faster than 100.00% of TypeScript online submissions for Defanging an IP Address.
Memory Usage: 33 MB, less than 100.00% of TypeScript online submissions for Defanging an IP Address.
*/

function defangIPaddr(address: string): string {
    return address.replace(/\./g, '[.]');
};