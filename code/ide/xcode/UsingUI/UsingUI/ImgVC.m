//
//  ImgVC.m
//  UsingUI
//
//  Created by plter on 13-8-14.
//  Copyright (c) 2013年 plter. All rights reserved.
//

#import "ImgVC.h"

@interface ImgVC ()

@end

@implementation ImgVC

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

//-(NSString*)description{
//    return @"";
//}

-(void)sayHi:(NSString *)name withContent:(NSString *)content{
    NSLog(@"%@ say %@",name,content);
}


-(void)btnClicked:(id)sender{
    
//    [self sayHi:@"ZhangDao" withContent:@"Hello"];
    
    [self dismissModalViewControllerAnimated:YES];
    
//    NSLog(@"Btn Clicked");
}


- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
