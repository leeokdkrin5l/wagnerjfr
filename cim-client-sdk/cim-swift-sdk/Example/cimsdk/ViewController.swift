//
//  ViewController.swift
//  cimsdk
//
//  Created by 飞鱼 on 09/25/2021.
//  Copyright (c) 2021 飞鱼. All rights reserved.
//

import UIKit
import cimsdk

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        
        let msg = Message(action: "0", sender: "111111", receiver: "123456", title: "hahaha", content: "content", format: "", extra: "")
        imClient.sendMessage(msg)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

