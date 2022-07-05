//
//  AutoReConnectInterceptor.swift
//  cimsdk
//
//  Created by FeiYu on 2021/10/1.
//

import Foundation

class AutoReConnectInterceptor: MessageInterceptor {
    
    var uniqueID: String = UUID().uuidString
    
    weak var client: CIMClient?
    
    init(client: CIMClient) {
        self.client = client
    }
    
    func connect(_ event: ConnectEvent) {
        switch event {
        case .connected(_):
            if let account = self.client?.account {
                var data: [String: String] = [:]
                data["uid"] = String(account.id)
                data["channel"] = "ios"
                data["deviceId"] = UIDevice.current.identifierForVendor?.uuidString
                if let token = account.token {
                    data["token"] = token
                }
                let body = SentBody(key: "client_bind", data: data)
                if let client = self.client {
                    client.sendMessage(body)
                }
            }
            break
        default:
            break
        }
    }
}
