int sum(int a, int b) {
   return a+b;
}

int sub(int a, int b) {
   return sum(a, -b);
}
void main() {
   int a;
   int b = 5;
   int c = 0;
   for(a = 0; a < b; ++c){
        a = c + a;
   }
   return;
}