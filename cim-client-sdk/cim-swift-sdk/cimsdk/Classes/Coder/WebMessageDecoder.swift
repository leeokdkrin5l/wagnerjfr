//
//  WebMessageDecoder.swift
//  cimsdk
//
//  Created by FeiYu on 2021/9/27.
//

import Foundation

class WebMessageDecoder {
    
    let messageFactory = MessageFactory()
    
    func decoder(_ data: Data) -> Transportable? {
        let msg = messageFactory.transportData(data)
        return msg
    }
}
