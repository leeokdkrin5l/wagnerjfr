//
//  WSClient.swift
//  cimsdk
//
//  Created by FeiYu on 2021/9/25.
//

import Foundation

open class CIMClient {
    
    var url: String
    
    var wsClient: WebsocketClient
    
    var account: Account? {
        get {
            return wsClient.account
        }
    }
    
    public init(url: String) {
        self.url = url
        self.wsClient = WebsocketClient(url: URL(string: url)!)
        self.wsClient.appendMessageInterceptor(MessageLogInterceptor())
        self.wsClient.appendMessageInterceptor(AutoReConnectInterceptor(client: self))
        self.wsClient.appendMessageInterceptor(HeartInterceptor(client: self))
    }
    
    public func connect(_ account: Account) {
        wsClient.connect(account)
    }
    
    public func disconnect() {
        wsClient.disconnect()
    }
    
    public func sendMessage(_ message: Transportable) {
        wsClient.sendMessage(message)
    }
    
    public func reConnect() {
        if (!wsClient.isConnected) {
            if let account = account {
                wsClient.connect(account)
            }
        }
    }
    
    public func appendMessageInterceptor(_ messageInterceptor: MessageInterceptor) {
        self.wsClient.appendMessageInterceptor(messageInterceptor)
    }
    
    public func removeMessageInterceptor(_ messageInterceptor: MessageInterceptor) {
        self.wsClient.removeMessageInterceptor(messageInterceptor)
    }
    
    public func appendMessageListener(_ messageListener: MessageListener) {
        self.wsClient.appendMessageListener(messageListener)
    }
    
    public func removeMessageListener(_ messageListener: MessageListener) {
        self.wsClient.removeMessageListener(messageListener)
    }
    
    public func appendConnectListener(_ connectListener: ConnectListener) {
        self.wsClient.appendConnectListener(connectListener)
    }
    
    public func removeConnectListener(_ connectListener: ConnectListener) {
        self.wsClient.removeConnectListener(connectListener)
    }
    
}

