//
//  ViewController.m
//  L12HelloiOS
//
//  Created by plter on 13-8-13.
//  Copyright (c) 2013年 plter. All rights reserved.
//

#import "ViewController.h"
#import "Hello.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    Hello * h = [[Hello alloc] init];
    NSLog(@"Count %d",[h retainCount]);
    [h release];
    
//    [[Hello alloc] autorelease];
    
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
