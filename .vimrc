"Convert tabs to 2 spaces in most settings
set tabstop=2
set shiftwidth=2
set expandtab

set autoindent

"Add line numbers
set number

"Use tabs in makefile
autocmd FileType make setlocal noexpandtab

"set initial color scheme for a dark background
set background=dark

"turn off the annoying bell
set vb t_vb=

"map background swapping to function keys
map <F2> :set background=light<CR>
map <F3> :set background=dark<CR>

"compile and run with function keys (assuming a local makefile exists)
map <F5> :make<CR>
map <F6> :make run<CR>

"quick commands for common make targets
:command M !make
:command Mr !make run
:command Md !make debug
:command Mv !make valgrind
:command Mc !make clean


"quick run python
:command Rp !python3 %

"quick compile and run java
:command Cj !javac %
:command Rj !java %<

"quick compile and run C++
"Ocp is compile to object file
"Lcp is link all object files
:command Ccp !g++ -g %
:command Ocp !g++ -g -c %
:command Lcp !g++ -g *.o
:command Rcp !./a.out

"quick compile and run C
:command Cc !gcc -g %
:command Rc !./a.out

"quick debugging
:command Db !gdb a.out
:command Vg !valgrind --leak-check=full ./a.out

