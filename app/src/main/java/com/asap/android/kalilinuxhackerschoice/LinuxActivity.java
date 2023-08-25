package com.asap.android.kalilinuxhackerschoice;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.interstitial.InterstitialAd;

public class LinuxActivity extends AppCompatActivity {

    RecyclerView recyclerV;
    private InterstitialAd mInterstitialAd;
    RecAdapter recAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux);


        //  searchView = findViewById(R.id.searchview);
        // searchView.clearFocus();





                            Window window = getWindow();

                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                            window.setStatusBarColor(this.getResources().getColor(R.color.statcolor));
                            // Window window = getWindow();
                            //window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.TYPE_STATUS_BAR);

                            ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Linux Commands");
                            actionBar.setHomeAsUpIndicator(R.drawable.ic_previous);
                            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#131313")));



                            recyclerV = findViewById(R.id.recyclvw);


                String title[] = {"Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts",
                        "Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts","Keyboard Shortcuts",
                        "Keyboard Shortcuts","Keyboard Shortcuts",
                        "File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation",
                        "File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation",
                        "File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation",
                        "File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation","File & Directory Manipulation",
                        "File & Directory Manipulation",
                        "System & User Information","System & User Information","System & User Information","System & User Information","System & User Information","System & User Information","System & User Information","System & User Information","System & User Information",
                        "System & User Information","System & User Information","System & User Information","System & User Information","System & User Information","System & User Information","System & User Information","System & User Information","System & User Information",
                        "Installing & Upgrading Packages","Installing & Upgrading Packages","Installing & Upgrading Packages","Installing & Upgrading Packages","Installing & Upgrading Packages","Installing & Upgrading Packages","Installing & Upgrading Packages","Installing & Upgrading Packages",
                        "Installing & Upgrading Packages","Installing & Upgrading Packages","Installing & Upgrading Packages","Installing & Upgrading Packages",
                        "Processes & Job Management","Processes & Job Management","Processes & Job Management","Processes & Job Management","Processes & Job Management","Processes & Job Management","Processes & Job Management","Processes & Job Management","Processes & Job Management","Processes & Job Management","Processes & Job Management",
                        "Networking Utilities",  "Networking Utilities",   "Networking Utilities",   "Networking Utilities",   "Networking Utilities",   "Networking Utilities",   "Networking Utilities",   "Networking Utilities",   "Networking Utilities",
                        "Secure File Transfer (SCP)","Secure File Transfer (SCP)","Secure File Transfer (SCP)","Secure File Transfer (SCP)","Secure File Transfer (SCP)",
                        "Hardware Information","Hardware Information","Hardware Information","Hardware Information","Hardware Information","Hardware Information","Hardware Information","Hardware Information","Hardware Information","Hardware Information","Hardware Information",
                        "File Compression","File Compression","File Compression","File Compression",
                        "SSH Login","SSH Login","SSH Login","SSH Login",
                };




                String main[] = {"CTRL + L","CTRL + D","CTRL + C","CTRL + Z", "CTRL + W", "CTRL + E", "CTRL + A","CTRL + F", "CTRL + B","CTRL + U","CTRL + K","CTRL + Y","clear","reset","exit","tab","!!","sudo !!","man <cmd>","which <cmd>",
                        "pwd","ls","ls -la","cd","cd /user/Desktop","cd ..","mkdir <dir>","mkdir /home/Desktop/dir","touch <file>","nano <file>","cp <file1> <file2>","cp -r <dir1> <dir2>","cp <file> /home/Desktop/file2","mv <file> /home/Desktop","mv <dir> /home/Desktop",
                        "mv <dir1> <dir2>","rm <file>","rm -f <file>","rm -r <dir>","rm -rf <dir>","cat <file>","less <file>","head <file>","head -20 <file>","tail <file>","tail -20 <file>","diff <file1> <file2>",
                        "cal","date","uptime","uname -a","dmesg","poweroff","reboot","df -h","fdisk -l","free","cat /proc/meminfo","cat /proc/cpuinfo","whoami","w","history","last","last <user>","finger <user>",
                        "apt-cache pkgnames","apt search <name>","apt show <name>","apt-get install <name>","apt-get install <name1> <name2>","apt-get update","apt-get upgrade","apt-get dist-upgrade","apt-get autoremove",
                        "apt-get clean","apt-get remove","apt-get remove --purge",
                        "top","ps","ps -u <user>","kill <PID>","killall <processes>","jobs","jobs -l","jobs -r","bg","fg","fg <job>",
                        "ping <host>","whois <domain/IP>","dig <domain/IP>","nslookup: <NS>","ifconfig","iwconfig","netstat -r","netstat -antp","arp -a",
                        "scp /path/to/file user@host:/path/to/dest","scp user@host:/path/to/file /path/to/dest","scp -r /path/to/dir user@host:/path/to/dest","scp /path/to/*.txt user@host:/path/to/dest","cat ~/.ssh/id_rsa.pub | ssh user@host 'cat >> .ssh/authorized_keys'",
                        "Dmesg","Cat/proc/cpuinfo","free –h","lshw","lsblk","lspci –tv","lsusb –tv","dmidecode","hdparm -i /dev/[disk]","hdparm -tT /dev/[disk]","badblocks -s /dev/[disk]",
                        "tar cf [file.tar] [file]","tar xf [file.tar]","tar czf [file.tar.gz]","gzip [file]",
                        "ssh [user]@[host]","ssh [host]","ssh -p [port] [user]@[host]","telnet [host]",
                };



                        String[] desc = {"Clear terminal screen","Log out of current session","Stop (halt) currently running command/processes","Suspend (pause) currently running command/processes","Delete the last word/argument","Jump (skip) to the very LAST line",
                                "Jump (skip) to the very FIRST line","Move cursor one letter forward","Move cursor one letter backward",
                                "Cut (copy) everything BEFORE the cursor","Cut (copy) everything AFTER the cursor","Paste previously copied text","Clear terminal screen","Fix display errors","Exit (log out) current session","Auto-complete",
                                "Repeat last command","Repeat last command as sudo (admin/root) user","Read the manual page of a command","Locate the path name of a command",
                                "Display path of current directory you’re in","List all files and folders in the current directory","la: List detailed list of files and folders, including hidden ones","Change to home directory","Change to a specific directory called Desktop",
                                "Move back a directory","Create a new directory","Create a directory in a specific location","Create an empty file","Edit an existing file or create it if it doesn’t exist","Create a copy of a file","Create a copy of a directory and everything in it","Create a copy of a file in a different directory and name it file2",
                                "Move a file to a specific directory (overwrites any existing file with the same name)","Move a directory to another location","Rename a file OR directory (dir1 -> dir2)","Delete a file","Force delete a file","Delete a directory and its contents","Force delete a directory and its contents","Display/output the contents of a file",
                                "Display the contents of a file with scroll (paginate) ability (press q to quit)","Display the first ten lines in a file","Display the first 20 lines in a file","Display the last ten lines in a file","Display the last 20 lines in a file","Check the difference between two files (file1 and file2)",
                                "Display monthly calendar","Check date and time","Check system uptime and currently logged in users","Display system information.","Display kernel ring buffer","Shutdown system","Reboot system","Display disk space usage","List disk partition tables","Display memory usage","Display memory information","Display cpu information","Output your username",
                                "Check who’s online","View a list of your previously executed commands","Display last login info of users","Display last login info of a specific user","Display user information",
                                "List all available packages","Search for a package and its description","Check detailed description of a package","Install a package","Install multiple packages","Update list of available packages","Install the newest version of available packages","Force upgrade packages","Remove installed packages that are no longer needed","Free up disk space by removing archived packages","Uninstall a package","Uninstall a package and remove its configuration files",
                                "Display running processes & system usage in real-time","Display currently running processes","Display currently running processes of a user","Kill a processes by PID #","Kill all processes with specified name","Display the status of current jobs","Display detailed info about each job","Display only running jobs","View stopped background jobs or resume job in the background","Resume recent job in the foreground","Bring specific job to the foreground",
                                "Ping a host","Get whois information about a domain or IP","Get DNS information","Get nameserver information","Configure/display network interfaces","Configure/display wireless network interfaces","Display kernel IP routing tables","Check for established and listening ports/connections","Display ARP cache tables for all interfaces",
                                "Transfer files FROM the local system TO a remote host (Local > Remote)","Transfer files FROM a remote host TO the local system (Remote > Local)","Transfer directories and everything within it","Transfer all files that match a specific filetype","Transfer local public SSH public key to remote host",
                                "Show bootup messages","Show CPU information","Show free and used memory","Hardware configuration info","Block devices info","Tree-diagram of PCI devices","Tree-diagram of USB devices","Show BIOS hardware info","Show disk data info","Disk read speed test","Unreadable blocks test",
                                "Create a tar file from a file","Extract archived file","Create a gzip tar file","Create a gz compressed file",
                                "Connect to host as user","Connect to host via port 22","Use a non-default port","Connect to Telnet via port 23",
                        };



                                recyclerV.setLayoutManager(new LinearLayoutManager(this));



                                recyclerV.setAdapter(new RecAdapter(this,title,main,desc));

        }
                                            /**
                                             @Override
                                             public boolean onCreateOptionsMenu(Menu menu) {
                                             getMenuInflater().inflate(R.menu.srch_menu,menu);
                                             MenuItem menuItem = menu.findItem(R.id.action_search);
                                             SearchView searchView = (SearchView) menuItem.getActionView();
                                             searchView.setQueryHint("Type to search");
                                             searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                             @Override
                                             public boolean onQueryTextSubmit(String query) {
                                             return false;
                                             }

                                             @Override
                                             public boolean onQueryTextChange(String newText) {
                                             return true;
                                             }
                                             });
                                             return super.onCreateOptionsMenu(menu);
                                             }
                                             **/
    }