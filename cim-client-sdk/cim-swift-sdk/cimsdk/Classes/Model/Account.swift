//
//  Account.swift
//  cimsdk
//
//  Created by FeiYu on 2021/10/1.
//

import Foundation

public struct Account: Codable {
    let id: Int64
    let name: String
    let token: String?
    
    public init(id: Int64, name: String, token: String?) {
        self.id = id
        self.name = name
        self.token = token
    }
}
