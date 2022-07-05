//
//  MessageFactory.swift
//  cimsdk
//
//  Created by FeiYu on 2021/9/29.
//

import Foundation

class MessageFactory {
    
    func transportData(_ data: Data) -> Transportable? {
        let bytes: [UInt8] = data.map{$0}
        let type = MessageType.Byte(rawValue: bytes[0])
        let body: [UInt8] = bytes[1..<bytes.count].map{$0}
        switch type {
        case .ping: return Ping()
        case .pong: return Pong()
        case .message: return Message(bytes: body)
        case .sentBody: return SentBody(bytes: body)
        case .replyBody: return ReplyBody(bytes: body)
        default: return nil
        }
    }
}
