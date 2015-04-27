package com.q.��һ��;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Booklist extends Frame implements ActionListener
{
	Vector savestring=new Vector();
	Frame f;
	TextField addbook;
	TextArea listbook;
	Label l1,l2;
	Button bopen,bexit,bsave,badd;

	public static void main(String args[])
	{
		Booklist bl=new Booklist();
		bl.init();
	}

	public void init()
	{
		f=new Frame("book list");
		f.setLayout(new FlowLayout());			//���ֹ���
		//������ǩ
		l1=new Label("Pla add your book here",Label.RIGHT);
		l2=new Label("Book list");
		//����������
		addbook= new TextField("",30);
		//����Ϣ������
		listbook=new TextArea("",7,35,TextArea.SCROLLBARS_BOTH);


		bopen=new Button("open");
		bsave=new Button("save");
		bexit=new Button("exit");
		badd=new Button("add");
		//�����ĸ�����
		bexit.addActionListener(this);
		bopen.addActionListener(this);
		bsave.addActionListener(this);
		badd.addActionListener(this);
		//������Ԫ�طŵ������
		f.add(l1);
		f.add(addbook);
		f.add(l2);
		f.add(listbook);
		f.add(bopen);
		f.add(bsave);
		f.add(bexit);
		f.add(badd);
		//��ʼʱ����Ӱ�ť�����水ť����Ϊ���ɰ�״̬
		badd.setEnabled(false);
		bsave.setEnabled(false);
		f.setSize(300,320);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bexit)
			System.exit(0);
		if(e.getSource()==bopen)
		{
			try{
				FileInputStream booklist=new FileInputStream("D:\\java\\booklist.txt");
				BufferedReader in=new BufferedReader(new InputStreamReader(booklist));
				for(int i=0; ;)
				{
					String book=in.readLine();
					if(book==null)
						break;
					listbook.append(book+"\n");
					savestring.addElement(book);
				}
				badd.setEnabled(true);
				bsave.setEnabled(true);
				in.close();
				booklist.close();
			}
			catch(FileNotFoundException ee)
			{
				ee.printStackTrace();
			}
			catch(IOException ee)
			{
				ee.printStackTrace();
			}
		}
		if(e.getSource()==badd)
		{
			String txt=addbook.getText();
			if(txt==null)
				return;
			else
			{
				listbook.append(txt+"\n");
				savestring.addElement(txt);
			}
		}
		if(e.getSource()==bsave)
		{
			try{
				FileOutputStream booklist=new FileOutputStream(
						"D:\\java\\booklist.txt");
				BufferedWriter out=new BufferedWriter(
						new OutputStreamWriter(booklist));
				for(int i=0;i<savestring.size();i++)
				{
					String book=savestring.elementAt(i).toString();
					out.write(book+"\n");
				}
				out.close();
				booklist.close();
			}
			catch(FileNotFoundException ee)
			{
				ee.printStackTrace();
			}
			catch(IOException ee)
			{
				ee.printStackTrace();
			}
		}
	}
}	

