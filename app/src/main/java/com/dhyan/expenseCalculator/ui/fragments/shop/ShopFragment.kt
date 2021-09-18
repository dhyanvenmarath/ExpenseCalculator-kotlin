package com.dhyan.expenseCalculator.ui.fragments.shop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.dhyan.expenseCalculator.databinding.FragmentShopBinding
import com.dhyan.expenseCalculator.db.ExpenseDatabase
import com.dhyan.expenseCalculator.models.AutoModel
import com.dhyan.expenseCalculator.repository.ShopRepository
import com.dhyan.expenseCalculator.utils.CommonMethods
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ShopFragment : Fragment() {
    private lateinit var viewModel:ShopViewModel
    private var _binding:FragmentShopBinding?=null
    private val binding get()=_binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding= FragmentShopBinding.inflate(inflater,container,false)
        val root:View=binding.root
        val shopRepository=ShopRepository(ExpenseDatabase(root.context.applicationContext))
        val viewModelProviderFactory=ShopViewModelProviderFactory(shopRepository)
        viewModel=
            ViewModelProvider(this,viewModelProviderFactory).get(ShopViewModel::class.java)
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {

            val sum = viewModel.totalAmountMutable.value
            sum?.observe(viewLifecycleOwner, { totalAmount->
                if (totalAmount.total==0.0){
                    binding.IdShopPrevAmountEdit.isFocusable=true
                    binding.IdShopPrevAmountEdit.hint="₹"+totalAmount.total.toString()
                }
                else{
                    binding.IdShopPrevAmountEdit.isFocusable=false
                    binding.IdShopPrevAmountEdit.setText( "₹"+totalAmount.total.toString())
                    print("dfdf")
                }
            })
        }

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun submitData(root: View){

        val commonMethod= CommonMethods()
        CommonMethods.hideKeyboard(root)
        val amountPaid = binding.IdShopPaidAmountEdit.text.toString()
        val creditAmount=binding.IdShopCreditAmountEdt.text.toString()

        if (amountPaid!="" || creditAmount!=""){
            val amountPaidDouble:Double = if (amountPaid!=""){
                amountPaid.toDouble()
            } else 0.0

            val creditDouble:Double = if (creditAmount!=""){
                creditAmount.toDouble()
            } else 0.0



//            val autoData= AutoModel(null,amount,commonMethod.currentDate)
//            viewModel.saveAutoData(autoData)
//            Snackbar.make(root, "Data saved successfully", Snackbar.LENGTH_SHORT).show()
//            binding.IdAutoEnterMoneyEdt.setText("")
        }
        else{
            Snackbar.make(root,"Enter an amount to continue..!", Snackbar.LENGTH_LONG).show()
        }
    }



}